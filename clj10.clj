;10.1
;Calcule a média de idade de uma coleção de pessoas. Faça uma função que receba um 
;vetor de pessoas, sendo cada pessoa um mapa contendo :nome e :idade.



; (defn media-idade [pessoas]
;     (def num-pessoas (count pessoas))
;     (defn media-idade-interna [l]
;         (if (empty? l)
;             0
;             (+ (:idade (first  l)) (media-idade-interna (rest l)))))
;     (/ (media-idade-interna pessoas) num-pessoas))

; (defn calcula-media-idade [v]
;     (def count-pessoas (count pessoas))
;     (loop [v count-pessoas]
;         (if (empty? v)
;         0
;         (recur (+ (:idade (first v)) (rest v))))))

    (def pessoas '({:nome "joao" :idade 15} {:nome "maria" :idade 30} {:nome "jose" :idade 40} {:nome "gustavo" :idade 15}))
    (defn media-idade[pessoas]
        (/ (reduce + (map (fn[p] (:idade p)) pessoas)) (count pessoas)))

;10.2
(defn conta-letras[palavra]
    (map (fn [letra] (conj '() :letra (inc 1))) palavra))
   
