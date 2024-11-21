// script.js
document.addEventListener('DOMContentLoaded', function() {
    // Datos de los signos del zodíaco
    const zodiacSigns = [
        {
            animal: '🐀',
            name: 'Rata',
            years: '1948, 1960, 1972, 1984, 1996, 2008, 2020',
            description: 'Inteligente, adaptable y vivaz'
        },
        {
            animal: '🐂',
            name: 'Buey',
            years: '1949, 1961, 1973, 1985, 1997, 2009, 2021',
            description: 'Honesto, diligente y determinado'
        },
        {
            animal: '🐅',
            name: 'Tigre',
            years: '1950, 1962, 1974, 1986, 1998, 2010, 2022',
            description: 'Valiente, confiado y carismático'
        },
        {
            animal: '🐇',
            name: 'Conejo',
            years: '1951, 1963, 1975, 1987, 1999, 2011, 2023',
            description: 'Elegante, amable y prudente'
        },
        {
            animal: '🐉',
            name: 'Dragón',
            years: '1952, 1964, 1976, 1988, 2000, 2012, 2024',
            description: 'Poderoso, noble y afortunado'
        },
        {
            animal: '🐍',
            name: 'Serpiente',
            years: '1953, 1965, 1977, 1989, 2001, 2013, 2025',
            description: 'Sabio, enigmático y intuitivo'
        }
    ];

    // Función para cargar los signos del zodíaco
    function loadZodiacSigns() {
        const container = document.getElementById('zodiacContainer');
        zodiacSigns.forEach((sign, index) => {
            const card = document.createElement('div');
            card.className = 'col-md-4 mb-4 fade-in';
            card.style.animationDelay = `${index * 0.2}s`;
            card.innerHTML = `
                <div class="temple-card">
                    <div class="temple-decoration"></div>
                    <div class="text-center">
                        <div class="zodiac-icon">${sign.animal}</div>
                        <h3>${sign.name}</h3>
                        <p>${sign.description}</p>
                        <div class="temple-pillar">
                            <small>Años: ${sign.years}</small>
                        </div>
                    </div>
                </div>
            `;
            container.appendChild(card);
        });
    }

    // Función para calcular el signo del zodíaco
    function calculateZodiacSign(year) {
        const animals = ['Mono', 'Gallo', 'Perro', 'Cerdo', 'Rata', 'Buey',
            'Tigre', 'Conejo', 'Dragón', 'Serpiente', 'Caballo', 'Cabra'];
        return animals[(year - 4) % 12];
    }

    // Manejador del formulario
    const horoscopeForm = document.getElementById('horoscopeForm');
    if (horoscopeForm) {
        horoscopeForm.addEventListener('submit', function(e) {
            e.preventDefault();
            const birthdate = new Date(document.getElementById('birthdate').value);
            const year = birthdate.getFullYear();
            const animal = calculateZodiacSign(year);

            // Crear modal de Bootstrap para mostrar el resultado
            const modalHtml = `
                <div class="modal fade" id="zodiacModal">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title">Tu Signo del Zodíaco Chino</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                            </div>
                            <div class="modal-body text-center">
                                <h2>${animal}</h2>
                                <p>${zodiacSigns.find(sign => sign.name === animal)?.description ||
            'Un signo lleno de características únicas y especiales.'}</p>
                            </div>
                        </div>
                    </div>
                </div>
            `;

            // Eliminar modal anterior si existe
            const oldModal = document.getElementById('zodiacModal');
            if (oldModal) {
                oldModal.remove();
            }

            // Añadir nuevo modal al documento
            document.body.insertAdjacentHTML('beforeend', modalHtml);

            // Mostrar el modal
            const modal = new bootstrap.Modal(document.getElementById('zodiacModal'));
            modal.show();
        });
    }

    // Inicializar tooltips de Bootstrap
    const tooltipTriggerList = [].slice.call(document.querySelectorAll('[data-bs-toggle="tooltip"]'));
    tooltipTriggerList.map(function (tooltipTriggerEl) {
        return new bootstrap.Tooltip(tooltipTriggerEl);
    });

    // Cargar los signos al iniciar
    loadZodiacSigns();

    // Añadir efectos de scroll
    window.addEventListener('scroll', function() {
        const cards = document.querySelectorAll('.temple-card');
        cards.forEach(card => {
            const cardTop = card.getBoundingClientRect().top;
            const windowHeight = window.innerHeight;
            if (cardTop < windowHeight * 0.8) {
                card.classList.add('fade-in');
            }
        });
    });
});