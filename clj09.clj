;9.1a  (Invertendo uma lista)

;Chamada recursiva ao nome da função
(defn inverter-lista1 [lista]
    (defn invert-interna [l]
        (if (empty? l)
            []
        (concat [(last l)] (invert-interna (drop-last l)))))
        (invert-interna lista))

;recursividade comum
; (defn inverter-lista-2 [v]
;  (loop [acum v]
;    (if (empty? v)
;      acum
;      (recur (cons (last v) (drop-last v))))))

(inveter-lista-2 [1 2 3 4 5 10])

;função conj

;Forma mais fácil...
(reverse sua-lista)
