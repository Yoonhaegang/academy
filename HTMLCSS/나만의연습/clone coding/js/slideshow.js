var slides = document.querySelectorAll("#slides > img");
var prev = document.getElementById("prev");
var next = document.getElementById("next");

var current = 0;

// 현재 이미지 표시
showSlides(current);
// 이전 이미지 표시
prev.onclick = prevSlide;
// 다음 이미지 표시
next.onclick = nextSlide;

function showSlides(n) {
    for(var i = 0; i < slides.length; i++) {
        // 모든 이미지를 화면에서 감춤
        slides[i].style.display = "none";
    }
    // n번째 이미지만 화면에 표시
    slides[n].style.display = "block";
}

function prevSlide() {
    if(current > 0) {
        // current 값이 0보다 크면 이전 위치로
        current -= 1;
    } else {
        // 그렇지 않으면(첫번째 이미지이므로) 마지막 위치로
        current = slides.length -1;
    }
    // 이동한 위치의 이미지 표시
    showSlides(current);
}

function nextSlide() {
    if(current < slides.length -1) {
        // current 값이 2보다 작으면 다음 위치로
        current += 1;
    } else {
        // 그렇지 않다면(마지막 이미지이므로)첫번째 위치로 이동
        current = 0;
    }
    // 이동한 위치의 이미지 표시
    showSlides(current);
}