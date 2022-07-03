let Empresa = {
    id:0,
    nombre:'',
    numeroNit:'',
    fechaFundacion:'',
    direccion:''
}

let empresas = [Empresa];

const tbody = document.getElementsByTagName('tbody')[0];

const btnAnadirEmpresa = document.getElementById("anadirEmpresa");
const btnEditEmpresa = document.getElementById("editEmpresa");
const btnEliminarEmpresa = document.getElementById("btEliminar");

btnEliminarEmpresa.addEventListener("click",eventELiminarEmpresa);

function eventELiminarEmpresa(event) {
    event.preventDefault();
    eliminarEmpresaById(Empresa.id);
    actualizarTabla();
    $("#deleteEmployeeModal").modal('hide');
}

btnEditEmpresa.addEventListener("click",eventEditarEmpresa);

function eventEditarEmpresa(event) {
    event.preventDefault();
    obtenerEmpresaHtml("edit");
    updadteEmpresaById(Empresa.id);
    actualizarTabla();
    $("#editEmployeeModal").modal('hide');
}
btnAnadirEmpresa.addEventListener("click", eventAnadirEmpresa);

function eventAnadirEmpresa(event) {
    event.preventDefault();
    obtenerEmpresaHtml("add");
    addEmpresaStorage();
    actualizarTabla();

    $("#addEmployeeModal").modal('hide');
}

function obtenerEmpresaHtml(from){
    const idWithNull     = document.getElementById(from+"Id");
    const id             = idWithNull.value===null?0:Number(idWithNull.value); 
    const nombre         = document.getElementById(from+"Nombre").value;
    const numeroNit      = document.getElementById(from+"NumeroNit").value;
    const fechaFundacion = document.getElementById(from+"FechaFundacion").value;
    const direccion      = document.getElementById(from+"Direccion").value;
    Empresa.id = id;
    Empresa.nombre = nombre;
    Empresa.numeroNit = numeroNit;
    Empresa.fechaFundacion = fechaFundacion; Empresa.direccion = direccion;
}

function addEmpresaStorage(){
    empresas = getLocalStorage();
    if(Array.isArray(empresas)){
        let maxID = empresas.map(x=>x.id).reduce((acc,val)=> acc>val?acc:val);
        maxID++;
        Empresa.id = maxID;
        empresas.push(Empresa);
    }else{
        empresas = [];
        Empresa.id = 0;
        empresas.push(Empresa);
    }
    addLocalStorage(empresas);
}


function getEmpresaById(id){
    empresas = getLocalStorage();
    empresas.forEach(emmpresaExistente => {
        let idNumber = Number(id);
        if(Number(emmpresaExistente.id)===idNumber){
           Empresa.nombre = emmpresaExistente.nombre ;
           Empresa.direccion = emmpresaExistente.direccion ;
           Empresa.fechaFundacion = emmpresaExistente.fechaFundacion;
           Empresa.numeroNit = emmpresaExistente.numeroNit ;
        }
    });
}

function eliminarEmpresaById(id) {
    empresas = getLocalStorage();
    let indexLocate = -1;
    indexLocate = empresas.findIndex(emp => Number(emp.id) === Number(id));


    if(indexLocate !== -1){
        empresas.splice(indexLocate,1);
    }

    addLocalStorage(empresas);
}

function updadteEmpresaById(id) {
    empresas = getLocalStorage();
    empresas.forEach(emmpresaExistente => {
        let idNumber = Number(id);
        if(Number(emmpresaExistente.id)===idNumber){
            emmpresaExistente.nombre = Empresa.nombre;
            emmpresaExistente.direccion = Empresa.direccion;
            emmpresaExistente.fechaFundacion = Empresa.fechaFundacion;
            emmpresaExistente.numeroNit = Empresa.numeroNit;
        }
    });

    addLocalStorage(empresas);
}
function addLocalStorage(empresas){
    window.localStorage.setItem('empresas', JSON.stringify(empresas));
}

function getLocalStorage(){;
    return JSON.parse(window.localStorage.getItem('empresas'));
}

function actualizarTabla(){
    empresas = getLocalStorage();
    if(empresas==null){
        return;
    }
    const filas = empresas.map(item =>{
        let tr = document.createElement("tr");
        tr.innerHTML = `
                <td>${item.id}</td>
                <td>${item.nombre}</td>
                <td>${item.numeroNit}</td>
                <td>${item.fechaFundacion}</td>
                <td>${item.direccion}</td>
                <td>
                    <a  href="#editEmployeeModal" class="edit" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="${item.id}">&#xE254;</i></a>
                    <a  href="#deleteEmployeeModal" class="delete" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="${item.id}">&#xE872;</i></a>
                </td>

            `;



        const [editar, eliminar] = tr.getElementsByTagName("a");
    
        editar.addEventListener("click", (event) => {
          event.preventDefault();
          const idEmpresa = event.target.title;
          if(typeof idEmpresa === 'string'|| idEmpresa instanceof String  ){
            getEmpresaById(idEmpresa);
            document.getElementById("editId").value = idEmpresa;
            document.getElementById("editNombre").value = Empresa.nombre;
            document.getElementById("editNumeroNit").value = Empresa.numeroNit;
            document.getElementById("editFechaFundacion").value = Empresa.fechaFundacion;
            document.getElementById("editDireccion").value = Empresa.direccion;
          }

        });


        eliminar.addEventListener("click", (event) => {
          event.preventDefault();
          const idEmpresa = event.target.title;
          if(typeof idEmpresa === 'string'|| idEmpresa instanceof String  ){
            Empresa.id = Number(idEmpresa);
          }
        });
    
    
        return tr;
    });

    tbody.innerHTML = "";
    filas.forEach((tr) => {
      tbody.appendChild(tr);
    });
  
  

    const tablaEmpresa = document.getElementById("tableEmpresa");

}

$( document ).ready(function() {
    actualizarTabla();
});