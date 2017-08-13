<#import "../pageLogin.ftl" as h>
<link rel="import" href="/webjars/polymer/1.8.0/polymer.html">

<dom-module id="page-login">
    <template>
    <@h.pageLogin email="${email!}"/>
    </template>

    <script>
        Polymer({
            is: 'page-login'
        });
    </script>
</dom-module>