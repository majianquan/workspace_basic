var canvas = document.getElementById('my-canvas');
var CanvasWidth = 400; // 画布宽度
var CanvasHeight = 400; // 画布高度
var CanvasStep = 40; // 动作步长
canvas.width = CanvasWidth;
canvas.height = CanvasHeight;

// 移动对象类
var Role = function(x, y, imgSrc) {
    this.position = { x, y };
    this.canvas = document.getElementById('my-canvas');
    this.ctx = this.canvas.getContext('2d');
    this.img = new Image();
    this.img.style.width = CanvasStep;
    this.img.style.height = CanvasStep;
    this.img.src = imgSrc;
    this.img.onload = () => {
        this.ctx.drawImage(this.img, x, y, CanvasStep, CanvasStep);
        this.move(0, 0);
    };
};

Role.prototype.move = function(x, y) {
    var pos = this.position;
    this.ctx.clearRect(pos.x, pos.y, CanvasStep, CanvasStep);
    pos.x += x;
    pos.y += y;
    this.ctx.drawImage(this.img, pos.x, pos.y, CanvasStep, CanvasStep);
};
