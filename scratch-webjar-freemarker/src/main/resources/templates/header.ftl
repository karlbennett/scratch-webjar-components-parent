<#macro header username>
<div class="header-container">
    <div class="signin">
        <#if username?has_content>
            <a href="/profile">${username}</a>
            <a href="/logout">Logout</a>
        <#else>
            <a href="/registration">Register</a>
            <a href="/login">Login</a>
        </#if>
    </div>
    <div class="menu">
        <a href="/">Home</a>
    </div>
</div>
</#macro>