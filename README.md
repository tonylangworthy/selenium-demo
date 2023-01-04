# Demonstrating various Selenium Automated Tests

The below are tested using Selenium

* Add and delete elements from a page
    * Using:  http://the-internet.herokuapp.com/add_remove_elements/
    * Test #1, testingAddElement() , adds and element then confirms it was added
    * Test #2, testingDeleteElement() , adds an element, deletes it and then confirms it was delete
* Confirming checkbox operation
    * Using http://the-internet.herokuapp.com/checkboxes
    * Page starts with two checkboxes, first unchecked, second checked.
    * Test toggles both, then confirms final result is first checked, second unchecked

* WYSIWYG formats contents of a text box in various ways
    * Using:  http://the-internet.herokuapp.com/tinymce
    * ??