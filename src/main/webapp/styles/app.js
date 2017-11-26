var stompClient = null;

function setConnected(connected) {
	 document.getElementById('connect').disabled = connected;
     document.getElementById('disconnect').disabled = !connected;
     document.getElementById('conversationDiv').style.visibility 
       = connected ? 'visible' : 'hidden';
     document.getElementById('response').innerHTML = '';
}

function connect() {
	
	
    var socket = new SockJS('/HRMMobileService/hrm-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/currentHRM', function(messageOutput) {
            showMessageOutput(JSON.parse(messageOutput.body));
            
        });
     });
    setInterval(sendName, 2000);
}

function disconnect() {
    if (stompClient != null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendName() {
	var from = document.getElementById('from').value;
    var text = document.getElementById('text').value;
    stompClient.send("/app/currentHRM", {}, JSON.stringify({'from':from, 'text':text}));
}

function showMessageOutput(messageOutput) {
    /*var response = document.getElementById('response');
    var p = document.createElement('p');
    p.style.wordWrap = 'break-word';
    p.appendChild(document.createTextNode(messageOutput.hrm + " " 
      + " (" + messageOutput.time + ")"));
    response.appendChild(p);*/
	document.getElementById('response').innerHTML = messageOutput.hrm + " " + " (" + messageOutput.time + ")"; 
}


