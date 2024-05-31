function openFileInput(fileInputId) {
    document.getElementById(fileInputId).click();
}

document.getElementById('fileInput1').addEventListener('change', function(event) {
    handleFileChange(event, 'previewImage1', 'container1');
});


function handleFileChange(event, previewImageId, containerId) {
    const file = event.target.files[0];
    if (file) {
        const reader = new FileReader();
        reader.onload = function(e) {
            const previewImage = document.getElementById(previewImageId);
            previewImage.src = e.target.result;
            previewImage.style.display = 'block';
            document.getElementById(containerId).classList.add('uploaded');
        };
        reader.readAsDataURL(file);
    }
}

function openCamera(cameraContainerId, videoId) {
    const cameraContainer = document.getElementById(cameraContainerId);
    cameraContainer.style.display = 'block';
    navigator.mediaDevices.getUserMedia({ video: true })
        .then(function(stream) {
            const video = document.getElementById(videoId);
            video.srcObject = stream;
            video.play();
        })
        .catch(function(err) {
            console.error('Error accessing camera: ', err);
        });
}

function takePicture(videoId, previewImageId) {
    const video = document.getElementById(videoId);
    const canvas = document.createElement('canvas');
    canvas.width = video.videoWidth;
    canvas.height = video.videoHeight;
    canvas.getContext('2d').drawImage(video, 0, 0);
    const dataUrl = canvas.toDataURL('image/png');

    const previewImage = document.getElementById(previewImageId);
    previewImage.src = dataUrl;
    previewImage.style.display = 'block';
    document.getElementById('container2').classList.add('taken');

    // Stop the video stream
    video.srcObject.getTracks().forEach(track => track.stop());
    document.getElementById('cameraContainer2').style.display = 'none';
}

function redirectToVerifyPage() {
    window.location.href = 'verify.html';
}
