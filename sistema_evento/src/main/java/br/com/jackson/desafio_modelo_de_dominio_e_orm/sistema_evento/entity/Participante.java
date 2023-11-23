package br.com.jackson.desafio_modelo_de_dominio_e_orm.sistema_evento.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name="tb_participante")
public class Participante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String email;

    @ManyToMany
    @JoinTable(
            name="tb_participante_atividade",
            joinColumns = @JoinColumn(name="participante_id"),
            inverseJoinColumns = @JoinColumn(name="atividade_id")
    )
    private Set<Atividade> atividades = new HashSet<>();


}
