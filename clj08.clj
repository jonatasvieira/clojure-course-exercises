;8.2a

(defn pert [el vet]
    (if (empty? vet)
    "Não"
    (if (= (first vet) el)
    "Sim"
    (pert el (rest vet)))))

(pert "qualquer coisa" [])  ; false
(pert 3 [1 2 3])  ; true
(pert 4 [1 2 3])  ; false


;8.2b
(defn conc [arr]
    (if (empty? arr) 
        ""
    (str (first arr) (conc (rest arr)))))

(conc [])  ; ""
(conc [1 2 3])  ; "123"
(conc [\a \b \c])  ; "abc"
(conc ["abc" 123 true])  ; "abc123true"

;8.2c
(defn acr [el arr]
   (if (or (empty? arr) (<= el (first arr)))
    (conj arr el)
    (concat [(first arr)] (acr el (rest arr)))))
    
(acr 5 [])  ; [5]
(acr 1 [2 4 6])  ; [1 2 4 6]
(acr 3 [2 4 6])  ; [2 3 4 6]
(acr 5 [2 4 6])  ; [2 4 5 6]
(acr 7 [2 4 6])  ; [2 4 6 7]

;8.3
(defn elimina-um [el vet]
    (if (= (first vet) el)
    (rest vet)
    (concat [(first vet)] (elimina-um el (rest vet)))))

;8.4
(defn elimina-todos [el vet]
    (filter (fn[e] (not (= e el)))  vet))

;8.5
;; Corrigir pra fazer a eliminaçao manualmente.
(defn elimina-se-1 [vet predicado?]
    (if (empty? vet)
        []
        (if (not (predicado? (first vet)))
            (cons (first vet) (elimina-se-1 (rest vet) predicado?))
            (elimina-se-1 (rest vet) predicado?))))
        
;8.6
(defn elimina-se-2 [vet predicado?]
    (filter #(predicado? %)  vet))

;8.7
(defn conc2 [vet]
	(apply str vet))
;8.8
(defn soma-dos-positivos [vet]
	(reduce + (filter pos? vet)))
