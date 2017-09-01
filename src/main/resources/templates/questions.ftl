[#ftl]
[#-- @ftlvariable name="questionList" type="java.util.List<String>" --]
[#-- @ftlvariable name="question" type="java.lang.String" --]
[#import "/spring.ftl" as spring/]
<!doctype html>
<html lang="en" xmlns:th="http://www.w3.org/1999/xhtml">
<head>
    <title>Questions</title>
</head>
<body>
<h1>Questions</h1>
<p id="content">
    <form method="POST" action="/score" id="quizForm">
        [@spring.bind "quizForm" /]
        [#list questionList as question]
            ${question}<br>
            [@spring.formInput "quizForm.answers[${question_index}]" /] <br><br>
        [/#list]
        <input type="submit" value="Submit" />
    </form>

</p>
</body>
</html>