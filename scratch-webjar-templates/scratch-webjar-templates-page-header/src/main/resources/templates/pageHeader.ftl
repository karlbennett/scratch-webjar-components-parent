<#import "pageLogin.ftl" as pl>
<#macro pageHeader email>
<div class="header-container">
    <@pl.pageLogin email="${email}"/>
    <div class="menu">
        <a href="/">Home</a>
    </div>
</div>
</#macro>