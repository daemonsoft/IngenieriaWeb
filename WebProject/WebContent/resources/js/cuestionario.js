var cuestionario = angular.module('modCuestionario', []);

cuestionario
		.controller(
				'contCuestionario',
				function($scope) {
					$scope.preguntas = [ {
						id : 1,
						texto : 'Pregunta 1',
						respuestaValida : 1,
						respuesta : null,
						estado : '',
						respuestas : [ {
							id : 1,
							texto : 'Respuesta 1.1'
						}, {
							id : 2,
							texto : 'Respuesta 1.2'
						}, {
							id : 3,
							texto : 'Respuesta 1.3'
						} ]
					}, {
						id : 2,
						texto : 'Pregunta 2',
						respuestaValida : 2,
						respuesta : null,
						estado : '',
						respuestas : [ {
							id : 1,
							texto : 'Respuesta 2.1'
						}, {
							id : 2,
							texto : 'Respuesta 2.2'
						}, {
							id : 3,
							texto : 'Respuesta 2.3'
						} ]
					}, {
						id : 3,
						texto : 'Pregunta 3',
						respuestaValida : 3,
						respuesta : null,
						estado : '',
						respuestas : [ {
							id : 1,
							texto : 'Respuesta 3.1'
						}, {
							id : 2,
							texto : 'Respuesta 3.2'
						}, {
							id : 3,
							texto : 'Respuesta 3.3'
						} ]
					} ];
					$scope.aciertos = '';
					$scope.respuestasCorrectas = 0;
					$scope.estadoUsuario = '';
					$scope.validar = function(pregunta) {
						if (pregunta.respuestaValida == pregunta.respuesta) {
							$scope.respuestasCorrectas++;
							pregunta.estado = 'ok';
						} else {
							if (pregunta.estado == 'ok'
									&& $scope.respuestasCorrectas > 0) {
								$scope.respuestasCorrectas--;
							}
							pregunta.estado = 'err';

						}
						estadoUsuario();
					};

					function estadoUsuario() {
						var total = $scope.respuestasCorrectas
								/ $scope.preguntas.lenght;
						if (total == 0) {
							$scope.estadoUsuario = 'looser';
						} else if (total == 1) {
							$scope.estadoUsuario = 'guru';
						} else {
							$scope.estadoUsuario = 'poor';
						}

					}

					$scope.enviar = function() {
						for (var i = $scope.preguntas.length - 1; i >= 0; i--) {
							if ($scope.preguntas[i].respuesta == null) {
								alert('Debe responder todas las preguntas.');
								return;
							}
						}
						for (var i = $scope.preguntas.length - 1; i >= 0; i--) {
							if ($scope.preguntas[i].respuestaValida == $scope.preguntas[i].respuesta) {
								if ($scope.preguntas[i].estado != 'ok') {
									$scope.respuestasCorrectas++;
								}
								$scope.preguntas[i].estado = 'ok';
							} else {
								if ($scope.preguntas[i].estado == 'ok'
										&& $scope.respuestasCorrectas > 0) {
									$scope.respuestasCorrectas--;
								}
								$scope.preguntas[i].estado = 'err';

							}
							estadoUsuario();
						}
						$scope.aciertos = 'Has acertado '.concat(
								$scope.respuestasCorrectas, ' de ',
								$scope.preguntas.length, ' preguntas');
					}

				});
