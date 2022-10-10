function showPassword() {
    const eye = document.getElementById ('eye');
    const noEye = document.getElementById ('noEye');
    const fieldPassword = document.getElementById ('field-password');
    
    if (eye.style.display === 'none') {
        eye.style.display = 'block';
        noEye.style.display = 'none';
        fieldPassword.type = 'text';
    } else {
        eye.style.display = 'none';
        noEye.style.display = 'block';
        fieldPassword.type = 'password';
    }
};

document.getElementById('btn-login').addEventListener('click',function(e) {
    e.preventDefault();
    alert('Você está logado!')
})