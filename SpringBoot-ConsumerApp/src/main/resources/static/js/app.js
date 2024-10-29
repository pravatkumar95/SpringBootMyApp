var stompClient;

const mybtn=document.getElementById('btn');

function connect(event) {

    var socket = new SockJS('/myApp');
    stompClient = Stomp.over(socket);
    if (socket.readyState === WebSocket.OPEN) {
    // WebSocket connection is open, so send the message
    socket.send(message);
} else {
    console.log('WebSocket connection is not open.');
}


    // Event listener for errors that occur during the WebSocket connection
    stompClient.connect({}, onConnected, onError);
    
    event.preventDefault();
}

function onConnected() {
    // Subscribe to the Public Topic
    stompClient.subscribe('/topic', onMessageReceived);

    
    // WebSocket connection is successfully established, so add event listeners
    stompClient.webSocket.onerror = onError;
    stompClient.webSocket.onclose = onClose;
}

function onMessageReceived(payload) {
    var message = JSON.parse(payload.body);
    // Handle received message
}

function sendToApp() {
    stompClient.send("/app/sendMessage/{id}", {}, JSON.stringify(message));
}

function onError(error) {
    console.error('WebSocket error:', error);
}

function onClose(event) {
    console.log('WebSocket connection closed:', event);
}

document.getElementById("btn").addEventListener("click",connect,true);



