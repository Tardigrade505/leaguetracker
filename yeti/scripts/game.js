$(document).ready(function () {
    displayGame();
});

function displayGame() {
    // Get season ID and players
    const urlParams = new URLSearchParams(window.location.search);
    console.log('All params = ' + urlParams.toString());
    const seasonId = urlParams.get('seasonId');
    const players = urlParams.get('playerList');
    console.log('Season ID = ' + seasonId);
    console.log('Players = ' + players);

    var url = "http://localhost:8080/games?" + urlParams.toString();
    console.log('Getting a new game from = ' + url);

    // Get a new game
    $.getJSON(url,
       function (json) {
           console.log('JSON returned = ' + json);

           // Display the tables of players, by looping through the table object
           for (i = 0; i < json.tables.length; i++) {
                var tablesText = $('<h2>');
                tablesText.append('<span style="font-weight: bold;">Table ' + (i+1) + '</span>' + ': ' + json.tables[i].players.toString());
                tablesText.append('</h2>');
                $('#table-header').append(tablesText);
           }

            // Display achievement images (last achievement is bonus achievement)
            for (i = 0; i < json.achievements.length-1; i++) {
                var image = $('<div class="col-lg-4 col-md-4 col-xs-4 thumb">');
                image.append('<a class="thumbnail" href="#">');
                image.append('<image class="img-fluid" src="images/' + json.achievements[i].name + '.png">');
                image.append('</a>');
                image.append('</div>');
                $('#achievements-row').append(image);
            }

            // Display the bonus achievement image
            var numberOfImages = json.achievements.length;
            var image = $('<div class="col-lg-4 col-md-4 col-xs-4 thumb">');
            image.append('<a class="thumbnail" href="#">');
            image.append('<image class="img-fluid" src="images/' + json.achievements[numberOfImages-1].name + '.png">');
            image.append('</a>');
            image.append('</div>');
            $('#bonus-achievement-row').append(image);

//           tablesText.append('</h2>');
//           $('#table-header').append(tablesText);

//           // Build the list out of the player list
//           // <button type="button" class="btn btn-outline-primary">Primary   <span class="close">&times;</span></button>
//           var buttonItemList = $('<li>');
//           for (var i = 0; i < json._embedded.playerList.length; i++) {
//                buttonItemList.append('<button type="button" class="btn btn-outline-primary" name="player-button" value=' + json._embedded.playerList[i].name + '>' + json._embedded.playerList[i].name + '<span class="close">&times;</span></button>');
//           }
//           buttonItemList.append('</li>');
//           console.log('List = ' + buttonItemList);
//           $('#missing-player-list').append(buttonItemList);
//
//
//           // Add event listener to close the buttons
//            var i;
//            var closebtns = document.getElementsByClassName("close");
//
//            for (i = 0; i < closebtns.length; i++) {
//                closebtns[i].addEventListener("click", function() {
//                this.parentElement.parentNode.removeChild(this.parentElement);
//                });
//            }
       });
}