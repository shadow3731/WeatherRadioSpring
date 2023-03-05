let socket = new WebSocket('ws://localhost:8080/');
let stompClient = Stomp.over(socket);

/*console.log("done");
document.getElementById("Any").innerText = "done";*/

stompClient.connect({}, frame => {
    console.log('Connected: ' + frame);

    stompClient.subscribe('/topic/greetings', greeting => {
        console.log(JSON.parse(greeting.body).content);
    });

    stompClient.send("/app/hello",
        {},
        JSON.stringify({'name':'John'}));
})