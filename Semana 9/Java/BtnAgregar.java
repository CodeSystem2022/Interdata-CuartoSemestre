@Autowired
  public LibroFrom(LibroServicio libroservicio){
    this.libroServicio = libroServicio;
agregarButton.addActionListener(e -> agregarLibro())  
  }

private void inicioForma(){
  
}

private void agregarLibro(){
  //Leer los valores del formulario
  if(libroTexto.getText().equals("")){
    mostrarMensaje("Ingresar el nombre del libro");
    libroTexto.requestFocusInWindows();
    return;
  }
  var nombreLibro = libroTexto.getText();
  var autor = autorTexto.getText();
  var precio = Double.parseDouble(precioTexto.getText());
  var existencias = Integer.parseInt(existenciasTexto.getText());
  // Creamos el objeto libro
  var libro = new Libro(null, nombreLibro, autor, precio, existencias);
 /* libro.setNombreLibro(nombreLibro);
  libro.setAutor(autor);
  libro.setPrecio(precio);
  libro.setExistencias(existencias);*/
  this.libroServicio.guardarLibro(libro);
  mostrarMensaje("Se agrego el libro...");
  limpiarFormulario();
  listarLibros();
}

private void limpiarFormulario(){
  libroTexto.setText("");
  autorTexto.setText("");
  precioTexto.setText("");
  existenciasTexto.setText("");
}

private void mostrarMensaje(String mensaje){
  JOptionPane.showMessageDialog(this, mensaje);
}
