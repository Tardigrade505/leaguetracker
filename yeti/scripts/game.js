$(document).ready(function () {
    displayGame();
    fillPlayerHeaders();
});

function nextPage() {
    // Get season ID and players
    const urlParams = new URLSearchParams(window.location.search);
    const seasonId = urlParams.get('seasonId');
    window.location.href="recordResults.html?seasonId=" + seasonId;
}

function fillPlayerHeaders() {
    // Get season ID and players
    const urlParams = new URLSearchParams(window.location.search);
    const seasonId = urlParams.get('seasonId');

    // Get all players in season
    $.getJSON("http://localhost:8080/seasons/" + seasonId + "/players",
        function (json) {
            console.log('JSON returned = ' + json);

            // Sort the players by most points
            json._embedded.playerList.sort(function(a, b) {
            return b.totalPoints - a.totalPoints;
            });

            // Store the player in first for later pages
            var playerInFirst = json._embedded.playerList[0].name;
            sessionStorage.setItem("playerInFirst", playerInFirst);

            var playerInFirstHeader = $('<h3>');
            playerInFirstHeader.append('<span style="font-weight: bold;">1st</span>' + ': ' + playerInFirst);
            playerInFirstHeader.append('</h3>');
            $('#player-in-first-header').append(playerInFirstHeader);

            // Store the player in last for later pages
            var playerInLast = json._embedded.playerList[json._embedded.playerList.length-1].name
            sessionStorage.setItem("playerInLast", playerInLast);

            var playerInLastHeader = $('<h3>');
            playerInLastHeader.append('<span style="font-weight: bold;">Bonus</span>' + ': ' + playerInLast);
            playerInLastHeader.append('</h3>');
            $('#player-in-last-header').append(playerInLastHeader);
});
}

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

           // Save the game in the current session
           // Put the object into storage
           sessionStorage.setItem('currentGame', JSON.stringify(json));

           // Display the tables of players, by looping through the table object
           for (i = 0; i < json.tables.length; i++) {
                var tablesText = $('<h2>');
                tablesText.append('<span style="font-weight: bold;">Table ' + (i+1) + '</span>' + ': ' + json.tables[i].players.toString());
                tablesText.append('</h2>');
                $('#table-header').append(tablesText);
           }

           // Display non-bonus achievement images (last achievement is bonus achievement)
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
           var image = $('<div class="col-lg-12 col-md-12 col-xs-12 thumb">');
           image.append('<a class="thumbnail" href="#">');
           image.append('<image class="img-fluid" src="images/' + json.achievements[numberOfImages-1].name + '.png">');
           image.append('</a>');
           image.append('</div>');
           $('#bonus-achievement-row').append(image);

            ////// DISPLAY ALL ACHIEVEMENTS BIG WITH BONUS ON NEXT LINE //////
//            // Display achievement images (last achievement is bonus achievement)
//            for (i = 0; i < json.achievements.length-1; i++) {
//                var image = $('<div class="col-lg-4 col-md-4 col-xs-4 thumb">');
//                image.append('<a class="thumbnail" href="#">');
//                image.append('<image class="img-fluid" src="images/' + json.achievements[i].name + '.png">');
//                image.append('</a>');
//                image.append('</div>');
//                $('#achievements-row').append(image);
//            }
//
//            // Display the bonus achievement image
//            var numberOfImages = json.achievements.length;
//            var image = $('<div class="col-lg-4 col-md-4 col-xs-4 thumb">');
//            image.append('<a class="thumbnail" href="#">');
//            image.append('<image class="img-fluid" src="images/' + json.achievements[numberOfImages-1].name + '.png">');
//            image.append('</a>');
//            image.append('</div>');
//            $('#bonus-achievement-row').append(image);
       });
}