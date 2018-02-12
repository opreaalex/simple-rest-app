var stompClient = null;

function connect() {
    console.log("Connecting to ws");
    var socket = new SockJS("/ws");
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        stompClient.subscribe("/topic/stocks", function (stock) {
            console.log("Received stock");
            appendStock(JSON.parse(stock.body));
        });
    });
}

function appendStock(stock) {
    $("#stocksContainer").append("<tr>"
        + "<td>" + stock.id + "</td>"
        + "<td>" + stock.name + "</td>"
        + "<td>" + stock.currentPrice + "</td>"
        + "<td>" + stock.lastUpdate + "</td>"
        + "</tr>");
}

$(document).ready(function() {
    connect();
});
