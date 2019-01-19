$(document).ready(function () {
    $.getJSON("http://localhost:8080/seasons",
    function (json) {
        var tbody;
        tbody = $('<tbody>');
        for (var i = 0; i < json._embedded.seasonList.length; i++) {
            var tr;
            if (i % 2 == 0) {
                tr = $('<tr>');
            } else {
                tr = $('<tr class="table-secondary">');
            }
            tr.append('<th scope="row">' + json._embedded.seasonList[i].name + '</th>');
            tr.append("<td>" + json._embedded.seasonList[i].id + "</td>");
            tr.append("</tr>");
            console.log(tr);
            tbody.append(tr);
//            $('#seasonTable').append(tbody);
        }
        tbody.append('</tbody>');
        $('#seasonTable').append(tbody);
        console.log(json);
        console.log("NIIIIIICE");
    });
});


//<tbody>
//<tr>
//        <th scope="row">Brawlin' 1</th>
//        <td>10</td>
//        <td>Stuff</td>
//        <td>Other stuff</td>
//    </tr>
//</tbody>