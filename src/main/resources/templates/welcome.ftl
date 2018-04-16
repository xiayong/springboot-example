<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>welcome</title>
	<script type="text/javascript" src="${rc.contextPath}/js/jquery-2.1.4.min.js"></script>
	<script>
        function showMsg() {
            alert("Hello.");
        }

	</script>
</head>
<body>
    Date: ${time?date}
	<br>
	Time: ${time?time}
	<br>
	Message: ${message}
    <a href="javascript:void(0)" onclick="showMsg()">SHOW MESSAGE.</a>
</body>
</html>