
    create table Alumnos (
        alumnoId bigint not null auto_increment,
        apellido varchar(255) not null,
        email varchar(255),
        githubUser varchar(255),
        legajo varchar(255) not null,
        nombre varchar(255) not null,
        secretCode varchar(255),
        primary key (alumnoId)
    )

    create table Asignaciones (
        asignacionId bigint not null auto_increment,
        tareaId bigint not null,
        alumnoId bigint not null,
        primary key (asignacionId)
    )

    create table Notas_Asignaciones (
        asignacionId bigint not null,
        nota varchar(255) not null
    )

    create table Tareas (
        tareaId bigint not null auto_increment,
        enunciado varchar(255) not null,
        fechaLimiteDeEntrega datetime not null,
        primary key (tareaId)
    )

    alter table Asignaciones 
        add constraint FK_qgwoi87g1whqatir5l3un9n4r 
        foreign key (tareaId) 
        references Tareas (tareaId)

    alter table Asignaciones 
        add constraint FK_j5qeo011jhjue99hkvdvy2mwc 
        foreign key (alumnoId) 
        references Alumnos (alumnoId)

    alter table Notas_Asignaciones 
        add constraint FK_238yj8iwi4em0d9a5t2v131kv 
        foreign key (asignacionId) 
        references Asignaciones (asignacionId)
