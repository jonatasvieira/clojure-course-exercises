;8.1
;;;;;;;;;;;;;;;;;
;a
(map dec [0 1 2])

;b
(filter odd? [1 2 3 4 5])

;c
(filter string? [0 true "abc" \x "def"])

;d
(every? string? ["a" "bc" "def"])

;e
(map count ["a" "bc" "def"])

;f
; solucao 1
(map count (filter string? ["a" \b 3 4 false "cde" "fg"]))

; solucao 2
(->> ["a" \b 3 4 false "cde" "fg"]
     (filter string?)
     (map count))

;8.2
;;;;;;;;;;;;;;;;;

;a
(defn pert [el v]
  (and
   (not (empty? v))
   (or
    (= el (first v))
    (pert el (rest v)))))

; (pert "qualquer coisa" [])  ; false
; (pert 3 [1 2 3])  ; true
; (pert 4 [1 2 3])  ; false

;b
(defn conc [v]
  (if (empty? v)
    ""
    (str (first v) (conc (rest v)))))

; (conc [])  ; ""
; (conc [1 2 3])  ; "123"
; (conc [\a \b \c])  ; "abc"
; (conc ["abc" 123 true])  ; "abc123true"

;c
(defn acr [el v]
  (if (or (empty? v) (<= el (first v)))
    (conj v el)
    (concat [(first v)] (acr el (rest v)))))

; (acr 5 [])  ; [5]
; (acr 1 [2 4 6])  ; [1 2 4 6]
; (acr 3 [2 4 6])  ; [2 3 4 6]
; (acr 5 [2 4 6])  ; [2 4 5 6]
; (acr 7 [2 4 6])  ; [2 4 6 7]


;8.3
;;;;;;;;;;;;;;;;;
(defn eliminar-um [vetor valor]
  (if (empty? vetor)
    []
    (if (= (first vetor) valor)
      (rest vetor)
      (cons (first vetor) (eliminar-um (rest vetor) valor)))))

(eliminar-um [1 1.5 2 3 2 2] 2)

;8.4
;;;;;;;;;;;;;;;;;
(defn eliminar-todos [vetor valor]
  (if (empty? vetor)
    []
    (if (= (first vetor) valor)
      (eliminar-todos (rest vetor) valor)
      (cons (first vetor) (eliminar-todos (rest vetor) valor)))))

(eliminar-todos [1 1.5 2 3 2 2] 2)

;8.5
;;;;;;;;;;;;;;;;;
(defn eliminar-se-1 [vetor predicado?]
  (if (empty? vetor)
    []
    (if (predicado? (first vetor))
      (eliminar-se-1 (rest vetor) predicado?)
      (cons (first vetor) (eliminar-se-1 (rest vetor) predicado?)))))

(eliminar-se [1 2 3 4 5 6] odd?)

;8.6
;;;;;;;;;;;;;;;;;
(defn eliminar-se-2 [vetor predicado?]
  (filter #(not (predicado? %)) vetor))

(eliminar-se-2 [1 2 3 4 5 6] odd?)

;8.7
;;;;;;;;;;;;;;;;;
(apply str ["abc" \d \e \f 789])

;8.8
;;;;;;;;;;;;;;;;;
(apply + (filter pos? [-2 -1 5 10]))
