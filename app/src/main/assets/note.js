var testnote = '# Getting Rid of Google\n\n \
- [x] Music - Deezer\n \
- [x] Photos - NextCloud\n \
- [x] Notes - NextCloud\n \
- [ ] Delete\n \
- [x] Maps\n \
- [x] Chromecast\n \
	- [x] Log in with new bookmark backup\n \
	- [x] lasdkfasdfasdf\n \
	- [ ] sdjfalskdjfasdf\n \
- [x] Music - Deezer\n \
- [x] Photos - NextCloud\n \
- [ ] Notes - NextCloud\n \
- [x] Delete\n \
- [x] Maps\n \
- [x] Chromecast\n \
	- [ ] Log in with new bookmark backup\n \
	- [ ]\n \
- [x] Music - Deezer\n \
- [x] Photos - NextCloud\n \
- [ ] Notes - NextCloud\n \
- [x] Delete\n \
- [ ] Maps\n \
- [ ] Chromecast\n \
- [x] Music - Deezer\n \
- [x] Photos - NextCloud\n \
- [x] Notes - NextCloud\n \
- [ ] Delete\n \
- [x] Maps\n \
- [x] Chromecast\n \
	- [x] Log in with new bookmark backup\n \
	- [x] lasdkfasdfasdf\n \
	- [ ] sdjfalskdjfasdf\n \
- [x] Music - Deezer\n \
- [x] Photos - NextCloud\n \
- [ ] Notes - NextCloud\n \
- [x] Delete\n \
- [x] Maps\n \
- [x] Chromecast\n \
	- [ ] Log in with new bookmark backup\n \
	- [ ]\n \
- [x] Music - Deezer\n \
- [x] Photos - NextCloud\n \
- [ ] Notes - NextCloud\n \
- [x] Delete\n \
- [ ] Maps\n \
- [ ] Chromecast'

function toggleCheckbox (el) {
    var $el = $(el);
    var cm = $('.CodeMirror')[0].CodeMirror;
    var doc = cm.getDoc();
    var index = $el.parents('.CodeMirror-line').index();
    var line = doc.getLineHandle(index);

    var newvalue = ( $el.text() === '[x]' ) ? '[ ]' : '[x]';

    // + 1 for some reason... not sure why
    doc.replaceRange(newvalue,
        {line: index, ch: line.text.indexOf('[')},
        {line: index, ch: line.text.indexOf(']') + 1}
    );
}


var simplemde = new SimpleMDE({
    element: document.getElementById('Note'),
    spellChecker: false,
    autoDownloadFontAwesome: false,
    toolbar: false,
    status: false,
    forceSync: true
});

var editorElement = $(simplemde.codemirror.getWrapperElement());



simplemde.value(testnote);
simplemde.codemirror.focus();

/* Initialize Checkboxes */
$('.CodeMirror-code').on('mousedown.checkbox touchstart.checkbox', '.cm-formatting-task', function (e) {
    e.preventDefault();
    e.stopImmediatePropagation();
    toggleCheckbox(e.target);
});

simplemde.codemirror.on('update', function () {
    // For strikethrough styling of completed tasks
    $('.CodeMirror-line').removeClass('completed-task');
    $('.CodeMirror-line:contains("[x]")').addClass('completed-task');
});
