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

            let errorMessage = 'Error accessing camera: ';
            if (err.name === 'NotFoundError' || err.name === 'DevicesNotFoundError') {
                errorMessage += 'No camera device found. Please ensure your camera is connected.';
            } else if (err.name === 'NotAllowedError' || err.name === 'PermissionDeniedError') {
                errorMessage += 'Permission denied. Please allow camera access in your browser settings.';
            } else if (err.name === 'NotReadableError' || err.name === 'TrackStartError') {
                errorMessage += 'Camera is already in use by another application.';
            } else if (err.name === 'OverconstrainedError' || err.name === 'ConstraintNotSatisfiedError') {
                errorMessage += 'Constraints could not be satisfied by any available camera devices.';
            } else {
                errorMessage += 'Unknown error occurred: ' + err.message;
            }

            alert(errorMessage);
            // Hide the camera container if the camera cannot be accessed
            cameraContainer.style.display = 'none';
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
