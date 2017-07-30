<#macro form button method="POST" action="">
<form class="form" method="${method}" action="${action}">
    <#nested>
    <input class="form-button" type="submit" value="${button}">
</form>
</#macro>