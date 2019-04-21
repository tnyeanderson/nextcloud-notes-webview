# Nextcloud Notes Webview

**Created using [slymax/webview](https://github.com/slymax/webview). Thanks slymax!!**

This Android app simply loads a webview of the online Nextcloud Notes app. Base URL is currently hardcoded in `strings.xml`.

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

    #app-navigation-toggle {
        width: 4em;
        height: 4em;
        margin-top: 1.5em;
    }

    #app-navigation {
        top: 0;
    }

    .CodeMirror {
        padding-top: 0;

        .CodeMirror-sizer,
        .CodeMirror-lines,
        .CodeMirror-code {
            border: none !important;
        }

        .CodeMirror-line {
            padding-left: 20px;
        }

        .CodeMirror-line:first-of-type {
            padding: 1.2em 0;
            padding-left: 3.5em;
            border-bottom: solid 1px #DDD;
            background: #FFF;
        }

        .CodeMirror-line:first-of-type .cm-formatting-header-1 {
            display: none !important;
        }
    }

    #app-content .note-meta {
        text-align: right;

        button.btn-fullscreen {
            display: none;
        }
    }
}
```
