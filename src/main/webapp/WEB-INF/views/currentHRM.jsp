<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Cyklosoft</title>
    <script src="<c:url value="/resources/styles/app.js"/>" ></script>
    <script src="<c:url value="/resources/styles/stomp.min.js"/>" ></script>
    <script src="<c:url value="/resources/styles/sockjs-1.0.0.min.js"/>" ></script>
    <script src="<c:url value="/resources/styles/jquery-3.1.1.min.js"/>" ></script>
</head>
<body onload="disconnect()">
Current HRM
        <div>
            <div>
                <input type="text" id="from" placeholder="Choose a nickname"/>
            </div>
            <br />
            <div>
                <button id="connect" onclick="connect();">Connect</button>
                <button id="disconnect" disabled="disabled" onclick="disconnect();">
                    Disconnect
                </button>
            </div>
            <br />
            <div id="conversationDiv">
                <input type="text" id="text" placeholder="Write a message..."/>
                <button id="sendMessage" onclick="sendName();">Send</button>
                <p id="response"></p>
            </div>
        </div>
    </body>
</html>        