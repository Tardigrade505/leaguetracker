var room = 1;
function addPlayerForm() {

//    console.log("Clicked");
    room++;
    var objTo = document.getElementById('player-form-list')
    var divtest = document.createElement("div");
	divtest.setAttribute("class", "form-group");
	var rdiv = 'removeclass'+room;
    divtest.innerHTML = '<p><input type="text" class="form-control" placeholder="The Puppet Master" id="player-name' + room + '" required="required" data-error="Player name is required." name="players"></p>';

    objTo.appendChild(divtest)
}