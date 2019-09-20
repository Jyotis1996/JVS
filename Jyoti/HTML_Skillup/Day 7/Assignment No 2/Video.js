var video = document.getElementById("video");

function playPause() {
    if (video.paused)
        video.play();
    else
        video.pause();
}

function makeBig() {
    video.width = 960;
}

function makeSmall() {
    video.width = 200;
}

function makeNormal() {
    video.width = 800;
}