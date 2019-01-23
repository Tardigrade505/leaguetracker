$(document).ready(function () {
    drawWinnersForms();
    drawAchievementWinnersForms();
});

function drawAchievementWinnersForms() {
// Building the object below
//          <div class="col-md-3">
//                <figure class="figure">
//                    <img src="images/yaBasic.png" class="figure-img img-fluid rounded" alt="A generic square placeholder image with rounded corners in a figure.">
//                    <figcaption class="figure-caption">
//                        <form>
//                            <div class="form-group">
//                                <!--<label for="exampleSelect2">Example select</label>-->
//                                <select class="form-control" id="exampleSelect11">
//                                    <option>1</option>
//                                    <option>2</option>
//                                    <option>3</option>
//                                    <option>4</option>
//                                    <option>5</option>
//                                </select>
//                            </div>
//                        </form>
//                    </figcaption>
//                </figure>
//            </div>

    // Retrieve the stored game and stored player in first and last
    var gameJSONString = sessionStorage.getItem('currentGame');
    var gameJSON = JSON.parse(gameJSONString);
    var playerInFirst = sessionStorage.getItem('playerInFirst');
    var playerInLast = sessionStorage.getItem('playerInLast');

    // Build the achievement winner forms (non-bonus achievements)
    for (i = 0; i < gameJSON.achievements.length; i++) {
        var columnWidth = $('<div class="col-md-3"></div>');
        var figure = $('<figure class="figure"></figure>');
        var image = $('<img src="images/' + gameJSON.achievements[i].name + '.png" class="figure-img img-fluid rounded">');
        var caption = $('<figcaption class="figure-caption"></figcaption>');
        var form = $('<form></form>');
        var formGroup = $('<div class="form-group"></div>');
        var selectForm = $('<select class="form-control"></select>');

        // Add the none option to the drop down list
        selectForm.append('<option>none</option>');

        // If this is the bonus achievement
        if (i == gameJSON.achievements.length-1) {
            selectForm.append('<option>' + playerInLast + '</option>');
        } else {
            // If not bonus achievement, add all players who are not in first place
            for (j = 0; j < gameJSON.tables.length; j++) {
                for (k = 0; k < gameJSON.tables[j].players.length; k++) {
                    if (gameJSON.tables[j].players[k] != playerInFirst) {
                        selectForm.append('<option>' + gameJSON.tables[j].players[k] + '</option>');
                    }
                }
            }
        }

        formGroup.append(selectForm);
        form.append(formGroup);
        caption.append(form);
        figure.append(image);
        figure.append(caption);
        columnWidth.append(figure);

        $('#achievement-winners-form').append(columnWidth);
    }
}

function drawWinnersForms() {
// Building the object below
//      <div class="row" id="winners-form"></div>
//            <div class="col-md-6">
//                <form>
//                    <div class="form-group">
//                        <label for="table-winner-1">Example select</label>
//                        <select class="form-control" id="table-winner-1">
//                            <option>1</option>
//                            <option>2</option>
//                            <option>3</option>
//                            <option>4</option>
//                            <option>5</option>
//                        </select>
//                    </div>
//                </form>
//            </div>
//            <div class="col-md-6">
//                <form>
//                    <div class="form-group">
//                        <label for="table-second-1">Example select</label>
//                        <select class="form-control" id="table-second-1">
//                            <option>1</option>
//                            <option>2</option>
//                            <option>3</option>
//                            <option>4</option>
//                            <option>5</option>
//                        </select>
//                    </div>
//                </form>
//            </div>
//        </div>
    // Retrieve the stored game
    var gameJSONString = sessionStorage.getItem('currentGame');
    var gameJSON = JSON.parse(gameJSONString);

    // Build the winners and seconders forms
    for (i = 0; i < gameJSON.tables.length; i++) {
        var resultsRow = $('<div class="row"></div>');
        var columnWidth = $('<div class="col-md-6"></div>');
        var form = $('<form></form>');
        var formGroup = $('<div class="form-group"></div>');
        var formLabel = $('<label for="table-' + (i+1) + '-winner">Table ' + (i+1) + ' Winner</label>');
        var selectForm = $('<select class="form-control" id="table-' + (i+1) + '-winner"></select>');
        var selectForm2 = $('<select class="form-control" id="table-' + (i+1) + '-second"></select>');

        for (j = 0; j < gameJSON.tables[i].players.length; j++) {
            selectForm.append('<option>' + gameJSON.tables[i].players[j] + '</option>');
            selectForm2.append('<option>' + gameJSON.tables[i].players[j] + '</option>');
        }

        formGroup.append(formLabel);
        formGroup.append(selectForm);
        form.append(formGroup);
        columnWidth.append(form);
        resultsRow.append(columnWidth);

        var columnWidth2 = $('<div class="col-md-6"></div>');
        var form2 = $('<form></form>');
        var formGroup2 = $('<div class="form-group"></div>');
        var formLabel2 = $('<label for="table-' + (i+1) + '-second">Table ' + (i+1) + ' Second Place</label>');

        formGroup2.append(formLabel2);
        formGroup2.append(selectForm2);
        form2.append(formGroup2);
        columnWidth2.append(form2);
        resultsRow.append(columnWidth2);

        $('#winners-form').append(resultsRow);
        $('#winners-form').append('<br>');
    }
}