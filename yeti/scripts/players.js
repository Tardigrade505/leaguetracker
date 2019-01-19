//import Player from './objects/Player.js';
    function getAllPlayers() {
        const urlParams = new URLSearchParams(window.location.search);
        const seasonId = urlParams.get('seasonId');
        console.log('Season ID = ' + seasonId);

        $.ajax({
                url: "http://localhost:8080/seasons/" + seasonId + "/players"
            }).then(function(data, status, jqxhr) {
               $('#seasons-id').text(jqxhr.responseText);
               $('#seasons-content').html("HI")

               console.log(data);
               console.log("HE");
               console.log("STRING");
               console.log('data._embedded.playerList = ' + data._embedded.playerList);

               data._embedded.playerList.sort(function(a, b) {
                                             return a.totalPoints - b.totalPoints;
                                         });
                console.log('Sorted first element = ' + data._embedded.playerList[0].name);
               var result = [];
               var tempPlayer;
               for (i = 0; i < data._embedded.playerList.length; i++) {
                    tempPlayer = $.extend(new Player(), data._embedded.playerList[i]);
                    result.push(tempPlayer);
               }
               console.log('Result = ' + result);
               result.sort(function(a, b) {
                    return (b.totalPoints - a.totalPoints);
               });
               console.log('Sorted results = ' + result);
               return data;
            });
        console.log('Getting all players');
    }


//    function getQueryVariable(variable)
//    {
//           var query = window.location.search.substring(1);
//           var vars = query.split("&");
//           for (var i=0;i<vars.length;i++) {
//                   var pair = vars[i].split("=");
//                   if(pair[0] == variable){return pair[1];}
//           }
//           return(false);
//    }
// });