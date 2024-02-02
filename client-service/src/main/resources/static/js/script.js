$(document).ready(function() {
    // Fetch user profile data from the backend
    $.ajax({
        url: '/api/userprofile', // Replace with your backend API endpoint
        method: 'GET',
        success: function(data) {
            // Update the profile information on the page
            $('#username').text(data.username);
            $('#fullname').text(data.fullname);
            $('#email').text(data.email);

            // Set the background image dynamically
            $('.background-image').css('background-image', 'url(' + data.backgroundImageUrl + ')');

            // Set the profile picture dynamically
            $('#profile-picture').attr('src', data.profilePictureUrl);
        },
        error: function(error) {
            console.log('Error fetching user profile data:', error);
        }
    });
});
