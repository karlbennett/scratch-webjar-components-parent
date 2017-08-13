<#import "../pageHeader.ftl" as h>
<link rel="import" href="/webjars/polymer/1.8.0/polymer.html">

<dom-module id="page-header">
    <link rel="import" type="css" href="/css/page-header.css">
    <template>
    <@h.pageHeader email="${email!}"/>
    </template>

    <script>
        Polymer({
            is: 'page-header'
        });
    </script>
</dom-module>