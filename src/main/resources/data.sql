-- Catégories
INSERT INTO categorie (id, nom, description)
SELECT 1, 'Antibiotiques', 'Médicaments utilisés pour traiter les infections bactériennes.'
WHERE NOT EXISTS (SELECT 1 FROM categorie WHERE id = 1);

INSERT INTO categorie (id, nom, description)
SELECT 2, 'Antalgiques', 'Médicaments pour soulager la douleur.'
WHERE NOT EXISTS (SELECT 1 FROM categorie WHERE id = 2);

INSERT INTO categorie (id, nom, description)
SELECT 3, 'Vitamines', 'Compléments nutritionnels et fortifiants.'
WHERE NOT EXISTS (SELECT 1 FROM categorie WHERE id = 3);

INSERT INTO categorie (id, nom, description)
SELECT 4, 'Antiseptiques', 'Produits désinfectants pour usage externe.'
WHERE NOT EXISTS (SELECT 1 FROM categorie WHERE id = 4);


-- Fournisseurs
INSERT INTO fournisseur (id, nom, contact, adresse)
SELECT 1, 'PharmaMaroc', 'contact@pharmamaroc.ma', 'Casablanca, Maroc'
WHERE NOT EXISTS (SELECT 1 FROM fournisseur WHERE id = 1);

INSERT INTO fournisseur (id, nom, contact, adresse)
SELECT 2, 'Medisup France', 'info@medisup.fr', 'Paris, France'
WHERE NOT EXISTS (SELECT 1 FROM fournisseur WHERE id = 2);

INSERT INTO fournisseur (id, nom, contact, adresse)
SELECT 3, 'Sandoz', 'export@sandoz.com', 'Bâle, Suisse'
WHERE NOT EXISTS (SELECT 1 FROM fournisseur WHERE id = 3);

INSERT INTO fournisseur (id, nom, contact, adresse)
SELECT 4, 'Cooper Pharma', 'support@cooperpharma.ma', 'Rabat, Maroc'
WHERE NOT EXISTS (SELECT 1 FROM fournisseur WHERE id = 4);

-- Detail des produits 
INSERT INTO detail_produit
(id, fabricant, pays_origine, composition, dosage, indications)
SELECT 1, 'Sanofi', 'France', 'Amoxicilline trihydratée 500 mg',
       '500 mg', 'Infections ORL et respiratoires'
WHERE NOT EXISTS (SELECT 1 FROM detail_produit WHERE id = 1);

INSERT INTO detail_produit
(id, fabricant, pays_origine, composition, dosage, indications)
SELECT 2, 'Bayer', 'Allemagne', 'Paracétamol 500 mg',
       '500 mg', 'Douleurs légères à modérées, fièvre'
WHERE NOT EXISTS (SELECT 1 FROM detail_produit WHERE id = 2);

INSERT INTO detail_produit
(id, fabricant, pays_origine, composition, dosage, indications)
SELECT 3, 'Pfizer', 'États-Unis', 'Vitamine C 1000 mg',
       '1000 mg', 'Renforcement immunitaire'
WHERE NOT EXISTS (SELECT 1 FROM detail_produit WHERE id = 3);

INSERT INTO detail_produit
(id, fabricant, pays_origine, composition, dosage, indications)
SELECT 4, 'Johnson & Johnson', 'Maroc', 'Povidone iodée 10%',
       '10%', 'Désinfection des plaies'
WHERE NOT EXISTS (SELECT 1 FROM detail_produit WHERE id = 4);

INSERT INTO detail_produit
(id, fabricant, pays_origine, composition, dosage, indications)
SELECT 5, 'GSK', 'Royaume-Uni', 'Ibuprofène 400 mg',
       '400 mg', 'Inflammations et douleurs musculaires'
WHERE NOT EXISTS (SELECT 1 FROM detail_produit WHERE id = 5);

--tags
INSERT INTO tag (id, libelle)
SELECT 1, 'Sans ordonnance'
WHERE NOT EXISTS (SELECT 1 FROM tag WHERE id = 1);

INSERT INTO tag (id, libelle)
SELECT 2, 'Prescription obligatoire'
WHERE NOT EXISTS (SELECT 1 FROM tag WHERE id = 2);

INSERT INTO tag (id, libelle)
SELECT 3, 'En promotion'
WHERE NOT EXISTS (SELECT 1 FROM tag WHERE id = 3);

INSERT INTO tag (id, libelle)
SELECT 4, 'Stock limité'
WHERE NOT EXISTS (SELECT 1 FROM tag WHERE id = 4);

INSERT INTO tag (id, libelle)
SELECT 5, 'Importé'
WHERE NOT EXISTS (SELECT 1 FROM tag WHERE id = 5);

-- les produits 
INSERT INTO produit
(id, nom, description, prix, code_barre, date_expiration,
 categorie_id, fournisseur_id, detail_id)
SELECT 1, 'Amoxicilline 500mg', 'Antibiotique à large spectre.',
       45.00, 'AMX500-2025', '2026-03-10', 1, 1, 1
WHERE NOT EXISTS (SELECT 1 FROM produit WHERE id = 1);

INSERT INTO produit
(id, nom, description, prix, code_barre, date_expiration,
 categorie_id, fournisseur_id, detail_id)
SELECT 2, 'Doliprane 500mg', 'Antalgique et antipyrétique.',
       25.50, 'DLP500-2025', '2025-11-01', 2, 2, 2
WHERE NOT EXISTS (SELECT 1 FROM produit WHERE id = 2);

INSERT INTO produit
(id, nom, description, prix, code_barre, date_expiration,
 categorie_id, fournisseur_id, detail_id)
SELECT 3, 'Vitamine C 1000mg',
       'Complément pour renforcer les défenses.',
       30.00, 'VITC1000-2025', '2026-06-15', 3, 3, 3
WHERE NOT EXISTS (SELECT 1 FROM produit WHERE id = 3);

INSERT INTO produit
(id, nom, description, prix, code_barre, date_expiration,
 categorie_id, fournisseur_id, detail_id)
SELECT 4, 'Bétadine Solution 10%', 'Désinfectant pour usage externe.',
       18.00, 'BETADINE10-2025', '2027-01-30', 4, 4, 4
WHERE NOT EXISTS (SELECT 1 FROM produit WHERE id = 4);

INSERT INTO produit
(id, nom, description, prix, code_barre, date_expiration,
 categorie_id, fournisseur_id, detail_id)
SELECT 5, 'Nurofen 400mg', 'Soulage la douleur et la fiévre.',
       42.00, 'NURO400-2025', '2026-02-20', 2, 3, 5
WHERE NOT EXISTS (SELECT 1 FROM produit WHERE id = 5);


-- associations entre produits et tags 
INSERT INTO produit_tag (produit_id, tag_id)
SELECT 1, 2
WHERE NOT EXISTS (
    SELECT 1 FROM produit_tag WHERE produit_id = 1 AND tag_id = 2
);

INSERT INTO produit_tag (produit_id, tag_id)
SELECT 2, 1
WHERE NOT EXISTS (
    SELECT 1 FROM produit_tag WHERE produit_id = 2 AND tag_id = 1
);

INSERT INTO produit_tag (produit_id, tag_id)
SELECT 2, 3
WHERE NOT EXISTS (
    SELECT 1 FROM produit_tag WHERE produit_id = 2 AND tag_id = 3
);

INSERT INTO produit_tag (produit_id, tag_id)
SELECT 3, 1
WHERE NOT EXISTS (
    SELECT 1 FROM produit_tag WHERE produit_id = 3 AND tag_id = 1
);

INSERT INTO produit_tag (produit_id, tag_id)
SELECT 3, 5
WHERE NOT EXISTS (
    SELECT 1 FROM produit_tag WHERE produit_id = 3 AND tag_id = 5
);

INSERT INTO produit_tag (produit_id, tag_id)
SELECT 4, 1
WHERE NOT EXISTS (
    SELECT 1 FROM produit_tag WHERE produit_id = 4 AND tag_id = 1
);

INSERT INTO produit_tag (produit_id, tag_id)
SELECT 4, 4
WHERE NOT EXISTS (
    SELECT 1 FROM produit_tag WHERE produit_id = 4 AND tag_id = 4
);

INSERT INTO produit_tag (produit_id, tag_id)
SELECT 5, 1
WHERE NOT EXISTS (
    SELECT 1 FROM produit_tag WHERE produit_id = 5 AND tag_id = 1
);

INSERT INTO produit_tag (produit_id, tag_id)
SELECT 5, 5
WHERE NOT EXISTS (
    SELECT 1 FROM produit_tag WHERE produit_id = 5 AND tag_id = 5
);