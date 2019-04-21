This app simply loads a webview of the online Nextcloud Notes app. URL is currently hardcoded.

To remove the header bar and fix other styling, the following must be added to the end of `custom_apps/notes/js/public/app.min.js`:

```
function isNativeApp() {
  return /notes\-android\/[0-9\.]+$/.test(navigator.userAgent);
 }

if (isNativeApp()) {
  var node = document.createElement('style');
  node.innerHTML += '#header {display: none !important}';
  node.innerHTML += '#content {padding-top: 0;}';
  node.innerHTML += '#app-navigation {top: 0}';
  node.innerHTML += '#app-navigation-toggle {width: 4em; height: 4em; margin-top: .5em}';
  node.innerHTML += '.CodeMirror-sizer {border: none}';
  node.innerHTML += '.CodeMirror-lines, .CodeMirror-code {border: none}';
  node.innerHTML += '.CodeMirror-line {padding-left: 20px !important}';
  node.innerHTML += '.CodeMirror-line:first-of-type {position: fixed; width: 100%; top: 0em; padding: 1.2em 0; padding-left: 3.5em !important; border-bottom: solid 1px #DDD; background: #FFF; z-index: 9999}';
  node.innerHTML += '.CodeMirror-line:first-of-type .cm-formatting-header-1 {display: none !important;}';
  node.innerHTML += '.CodeMirror {padding-top: 3.5em;}';
  document.body.appendChild(node);
}
```
