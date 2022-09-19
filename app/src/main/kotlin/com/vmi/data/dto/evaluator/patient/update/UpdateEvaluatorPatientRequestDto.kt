package com.vmi.data.dto.evaluator.patient.update

import com.fasterxml.jackson.annotation.JsonProperty
import com.vmi.data.entity.AssignEntity
import com.vmi.data.entity.PatientEntity
import com.vmi.service.MappingService


data class UpdateEvaluatorPatientRequestDto(
    @JsonProperty("evaluatorNumber")
    var evaluatorNumber: String,

    @JsonProperty("updateRange")
    var updateRange: List<RangeDto>
)

fun UpdateEvaluatorPatientRequestDto.addEvaluatorPatientRequestDtoToAssignEntityList(
    assignEntry: List<AssignEntity>,
    patientEntry: List<PatientEntity>,
    mappingService: MappingService
): List<AssignEntity> {
    val list: MutableList<AssignEntity> = emptyList<AssignEntity>().toMutableList()
    val rangeHashSet: HashSet<Int> = HashSet()
    updateRange.forEach {
        for (i in it.min..it.max) {
            rangeHashSet.add(mappingService.mappingPatientNumberToEvaluationCode(i))
        }
    }
    rangeHashSet
        .subtract(assignEntry.map { it.evaluationCode }.toSet())
        .intersect(patientEntry.map { it.evaluationCode }.toSet())
        .forEach { list.add(AssignEntity(it, evaluatorNumber)) }
    return list
}


fun UpdateEvaluatorPatientRequestDto.removeEvaluatorPatientRequestDtoToAssignEntityList(
    assignEntry: List<AssignEntity>,
    patientEntry: List<PatientEntity>,
    mappingService: MappingService
): List<AssignEntity> {
    val list: MutableList<AssignEntity> = emptyList<AssignEntity>().toMutableList()
    val rangeHashSet: HashSet<Int> = HashSet()

    updateRange.forEach {
        for (i in it.min..it.max) {
            rangeHashSet.add(mappingService.mappingPatientNumberToEvaluationCode(i))
        }
    }
    assignEntry
        .map { it.evaluationCode }.toList().intersect(rangeHashSet)
        .intersect(patientEntry.map { it.evaluationCode }.toSet())
        .forEach { list.add(AssignEntity(it, null)) }

    return list
}
