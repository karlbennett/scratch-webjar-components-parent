<#macro form button method="POST" action="">
<form class="form" method="${method}" action="${action}">
    <#nested>
    <input class="form-button" type="submit" value="${button}">
</form>
</#macro>

<#macro inputText label name>
<label for="${name}">${label}</label><input id="${name}" name="${name}">
</#macro>

<#macro inputPassword label name>
<label for="${name}">${label}</label><input id="${name}" name="${name}" type="password">
</#macro>