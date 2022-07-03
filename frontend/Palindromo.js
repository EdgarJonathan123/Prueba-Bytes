
const esPalindroma = frase => {
    frase = frase.toLowerCase();
    const fraseAlReves = darVuelta(frase);
    return fraseAlReves === frase;
}

const darVuelta = frase => {
    let fraseAlReves = "";
    for (let i = frase.length-1; i >= 0; i--) {
        fraseAlReves += frase[i];
    }
    return fraseAlReves;
}

var args = process.argv.slice(2);

args.forEach(val => {
    const palindroma = esPalindroma(val);
    const respuesta = palindroma?'si es palindroma':'no es palindroma';
    console.log('La palabra ',val , 'es palindroma? ',respuesta);
});

