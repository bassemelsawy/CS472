<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Choose</title>
</head>
<body>
<form method='post' action='ChooseServlet'>
    <p>Is JSP cool?</p>
    <input type='radio' value='1' name='radioJSPCool' ${radioJSPCool}><span>Yes</span><br/>
    <input type='radio' value='0' name='radioJSPCool' ${NotradioJSPCool}><span>No</span><br/>
    <input type='submit' name='btnSubmit' value='Submit'/>
    <p>Is JSF way cool?</p>
    <input type='radio' value='1' name='JSFwayCool' ${JSFwayCool}><span>Yes</span><br/>
    <input type='radio' value='0' name='JSFwayCool' ${NotJSFwayCool}><span>No</span><br/>
    <input type='submit' name='btnSubmit' value='Submit'/>
    <p>Is the moon made of cheese?</p>
    <input type='radio' value='1' name='moonCheese' ${moonCheese}><span>Yes</span><br/>
    <input type='radio' value='0' name='moonCheese'${NotJSFwayCool}><span>No</span><br/>
    <input type='submit' name='btnSubmit' value='Submit'/>
</form>
</body>
</html>
