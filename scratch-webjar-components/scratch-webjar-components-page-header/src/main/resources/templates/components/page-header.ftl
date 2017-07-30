<#import "../header.ftl" as h>
<link rel="import" href="/webjars/polymer/1.8.0/polymer.html">

<dom-module id="page-header">
    <link rel="import" type="css" href="/css/header.css">
    <template>
    <@h.header email="${email!}"/>
    </template>

    <script>
        Polymer({
            is: 'page-header'
        });
    </script>
</dom-module>