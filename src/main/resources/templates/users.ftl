<html>
<head>
    <title>Title</title>
    <link href="/css/styles.css" rel="stylesheet" type="text/css">
</head>

<div class="form-style-2">
    <div class="form-style-2-heading">
        Already in System!
    </div>
    <table>
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
        </tr>
    <#list usersFromServer as JUser>
        <tr>
            <td>${JUser.firstName}</td>
            <td>${JUser.lastName}</td>
        </tr>
    </#list>
    </table>
</div>
</body>
</html>
