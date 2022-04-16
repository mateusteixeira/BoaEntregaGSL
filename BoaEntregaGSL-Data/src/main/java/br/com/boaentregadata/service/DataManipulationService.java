package br.com.boaentregadata.service;

import br.com.boaentregadata.dto.DataManipulationDTO;
import br.com.boaentregadata.dto.MethodDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
public class DataManipulationService {

    public List<DataManipulationDTO> getDataManipulation() {
        MethodDTO kMeans = MethodDTO.builder().name("K-means").build();
        MethodDTO knn = MethodDTO.builder().name("KNN").build();
        MethodDTO naiveBayes = MethodDTO.builder().name("Naive Bayes").build();

        DataManipulationDTO dataMining = DataManipulationDTO.builder().type("Data Mining")
                .methodDTOS(Arrays.asList(kMeans, knn, naiveBayes))
                .build();

        MethodDTO confusionMatrix = MethodDTO.builder().name("Confusion Matrix").build();
        MethodDTO histogram = MethodDTO.builder().name("Histogram").build();
        MethodDTO hierarchical = MethodDTO.builder().name("Hierarchical").build();

        DataManipulationDTO visualization = DataManipulationDTO.builder().type("Visualization")
                .methodDTOS(Arrays.asList(confusionMatrix, histogram, hierarchical))
                .build();

        MethodDTO normalize = MethodDTO.builder().name("Normalize").build();
        MethodDTO truncate = MethodDTO.builder().name("Truncate").build();

        DataManipulationDTO manipulation = DataManipulationDTO.builder().type("Manipulation")
                .methodDTOS(Arrays.asList(normalize, truncate))
                .build();
        log.info("Construído métodos de Manipulação de Dados");
        return Arrays.asList(dataMining, visualization, manipulation);
    }
}
