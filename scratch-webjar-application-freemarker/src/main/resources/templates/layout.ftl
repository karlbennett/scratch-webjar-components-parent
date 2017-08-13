<#import "header.ftl" as h>
<#macro layout title heading>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">

    <link rel="stylesheet" type="text/css" href="/css/main.css">
    <link rel="stylesheet" type="text/css" href="/css/header.css">
    <link rel="stylesheet" type="text/css" href="/css/input-text.css">
    <link rel="stylesheet" type="text/css" href="/css/input-password.css">

    <title>${title}</title>
</head>
<body>
    <@h.header email="${email!}"/>

<div class="content-container">
    <h1 class="main-heading">${heading}</h1>

    <#nested>
</div>
</body>
</html>
</#macro>