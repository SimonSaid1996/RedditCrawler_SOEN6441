;(function(window) {

	'use strict';

    document.documentElement.className = 'js';
    var searchbar=" <form id=\"search\" class=\"form-inline my-2 my-lg-0\">\n" +
        "                    <input class=\"form-control mr-sm-2\" type=\"text\" id=\"searchKey\" name=\"searchKey\" placeholder=\"Search here!\" aria-label=\"Search\"><br>\n" +
        "                    <button class=\"btn btn-outline-success my-2 my-sm-0\" type=\"submit\">Search</button>\n" +
        "                </form>"
    jQuery("#searchbar").html('').append(searchbar);

    var webSoc = new WebSocket('ws://localhost:9000/WebSocket');

    webSoc.onopen = function(message){

        var guid = navigator.mimeTypes.length;
        guid = guid + navigator.userAgent.replace(/\D+/g, '');
        guid += navigator.plugins.length;
        webSoc.send('--guid' +guid);
        setInterval(myTimer, 10000);

        function myTimer() {
            webSoc.send("");
        }


        var names="<div class='row'>" +
            "<div class='col-sm-12'><br><br></div>" +
            "<div class='col-sm-12'>" +
            "<br>" +
            "<br>" +
            "<hr>" +
            "<h3 class='heading-center' style=' text-align:center;'>This is a project for SOEN 6441 </h3>" +
            "<h4 class='heading-center' style=' text-align:center;'>Yugansh Goyal PART_C 40192444</h4>" +
            "<h4 class='heading-center' style=' text-align:center;'>Ziran Cao PART_B  40160723</h4>" +
            "<h4 class='heading-center' style=' text-align:center;'>POOYA ZARGARAN PART_A  40202551</h4>" +
            "</div>" +
            "</div>";
        jQuery("#ine").html('').append(names);
    };

    webSoc.onmessage = function(message){
        console.log(message);
        var parsedResult = JSON.parse(message.data);
        console.log(parsedResult[0].searchKey);
        console.log(parsedResult[0].results[0].author);
        jQuery("#ine").html('');
        for(var counter = 0;counter<parsedResult.length;counter++){
            var tableData="re";
            var searchKey = parsedResult[counter].searchKey;
            var tableId = searchKey + "Table";
            console.log(tableId);
            tableData = "<div id='"+tableId+"' class=\"col-sm-12-auto\">";
            tableData += "<table class=\"table table-striped table-light rounded \">";
            tableData += "<thead class=\"thead-dark\">";
            tableData += "<th > #"+(counter+1)+" Results of Search For:\n<a href='/DistW/"+parsedResult[counter].searchKey+"'>"+parsedResult[counter].searchKey+" </a></th>";
            tableData += "</thead>";
            tableData += "<th scope='col'>Auther</th>";
            tableData += "<th scope='col'>Title</th>";
            tableData += "<th scope='col'>Subreddit</th>";
            tableData += "</thead>";
            for(var index = 0;index<parsedResult[counter].results.length;index++){
                tableData += "<tr scope='row'><td>"+parsedResult[counter].results[index].author+"</td>" +
                    "<td><a href='"+parsedResult[counter].results[index].submissionLink+"' target='_blank'> "+parsedResult[counter].results[index].title+"</a></td>" +
                    "<td>"+parsedResult[counter].results[index].subreddit+"</td></tr>";
            }
            tableData += "</table>";
            tableData += "<div class=\"col-sm-12\"><br></br></div>";
            tableData += "</div>";
            jQuery("#ine").append(tableData);
        }

        console.log("chal ja")
    };
    webSoc.onclose = function() {
        webSoc.send("")
        console.log('Connection was closed.');
    };
    webSoc.error =function(err){
        console.log(err);
    }
    window.addEventListener("unload", function () {
        if(webSoc.readyState == WebSocket.OPEN)
            webSoc.close();
    });

    jQuery('#search').submit(function (e) {
        e.preventDefault();

        if($('#searchKey').val() != '') {
            var sear = $('#searchKey').val();
            sear = sear.replace(/\s/g, '_');
            webSoc.send(sear);
        }

    });
    var websocketsearch = function(searchKey){

        if(searchKey != '') {
            searchKey = searchKey.replace(/\s/g, '_');
            webSoc.send(searchKey);
        }

    }


})(window);
