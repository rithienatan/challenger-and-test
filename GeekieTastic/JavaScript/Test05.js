let i;

for(i = 0; i < 3; i++)
{ 
    const print = (x => _ => console.log(x*i))(i);

    setTimeout(print, 100);
}