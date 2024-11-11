<!DOCTYPE html>
<html>
<head>
    <title>天启官网</title>
</head>

<body>
    <h1>天启官网</h1>
    <p>欢迎来到天启官网！</p>
    <ul>
        <#list menuItems as item>
            <li><a href="${item.url}">${item.label}</a></li>
        </#list>
    </ul>
    <#-- 底部版权信息 -->
    <footer>
        ${currentYear} 天启官网. All rights reserved.
    </footer>
</body>

</html>
