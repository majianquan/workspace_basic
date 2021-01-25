var btn = document.getElementById('btn');
function setColor(ele, color = 'black', bgc = 'lightgray') {
    ele.style.setProperty('color', color);
    ele.style.setProperty('background-color', bgc);
}
function setSize(ele, size = '1') {
    ele.style.setProperty('transform', `scale(${size})`);
}
btn.addEventListener('mouseover', function() {
    setColor(btn, 'blue', 'green');
    setSize('1.5');
});
btn.addEventListener('mouseleave', function() {
    setColor(btn);
    setSize();
});
btn.addEventListener('mousedown', function() {
    setColor(btn, 'red', 'purple');
    setSize('.5');
});
btn.addEventListener('mouseup', function() {
    setColor(btn);
    setSize();
});
