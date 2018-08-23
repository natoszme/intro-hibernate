
    create table Alumno (
        id bigint not null auto_increment,
        apellido varchar(255) not null,
        email varchar(255),
        githubUser varchar(255),
        legajo varchar(255) not null,
        nombre varchar(255) not null,
        secretCode varchar(255),
        primary key (id)
    )

    create table Asignacion (
        id bigint not null auto_increment,
        tareaId bigint not null,
        idAlumno bigint,
        primary key (id)
    )

    create table Asignacion_notas (
        Asignacion_id bigint not null,
        notas varchar(255)
    )

    create table Tarea (
        id bigint not null auto_increment,
        enunciado varchar(255) not null,
        fechaLimiteDeEntrega datetime not null,
        primary key (id)
    )

    alter table Asignacion 
        add constraint FK_6mddi497j97l040w0xh0uru9c 
        foreign key (tareaId) 
        references Tarea (id)

    alter table Asignacion 
        add constraint FK_d6w2cqxnm8plr3ujay37aowoy 
        foreign key (idAlumno) 
        references Alumno (id)

    alter table Asignacion_notas 
        add constraint FK_2nu3de42ulnsxpwy48m3u4wrn 
        foreign key (Asignacion_id) 
        references Asignacion (id)
