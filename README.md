# Nextcloud Notes Webview

**Created using [slymax/webview](https://github.com/slymax/webview). Thanks slymax!!**

This Android app simply loads a webview of the online Nextcloud Notes app. URL is currently hardcoded in `MainActivity.java`.

## Add Javascript
To remove the header bar and fix other styling, the following must be added to the end of `custom_apps/notes/js/public/app.min.js`:

```
document.documentElement.setAttribute('data-useragent',  navigator.userAgent);
```

## Add Custom CSS
To remove the header bar and fix other styling, the following must be added to the end of `custom_apps/notes/css/public/notes.scss`:

```
html[data-useragent*='notes-android'] {
    #header {
        display: none !important
    }

    #content {
        padding-top: 0;
    }

    #app-navigation {
        top: 0
    }

    #app-navigation-toggle {
        width: 4em; height: 4em; margin-top: .5em
    }

    .CodeMirror {
        padding-top: 3.5em;

        .CodeMirror-sizer,
        .CodeMirror-lines,
        .CodeMirror-code {
            border: none !important;
        }

        .CodeMirror-line {
            padding-left: 20px !important
        }

        .CodeMirror-line:first-of-type {
            position: fixed;
            width: 100%;
            top: 0em;
            padding: 1.2em 0;
            padding-left: 3.5em !important;
            border-bottom: solid 1px #DDD;
            background: #FFF;
            z-index: 9999
        }

        .CodeMirror-line:first-of-type .cm-formatting-header-1 {
            display: none !important;
        }
    }
}
```
